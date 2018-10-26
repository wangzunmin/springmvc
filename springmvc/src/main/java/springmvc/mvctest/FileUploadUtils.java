package springmvc.mvctest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 文件上传utils
 * @author wzm
 * @date 2018-05-08
 */
public class FileUploadUtils {
	// 最大文件大小 一共最多能上传100M
	private static long maxSize = 1024 * 1024 * 100;
	// 上传临时路径
	private static final String TEMP_PATH = "/temp";
	private static final String ENCODE = "UTF-8";
	// 临时文件保存目录路径
	private static String tempPath;
	
	private static String SEPARATOR = System.getProperty("file.separator");
	
	
	
	
	/**
	 * 文件上传
	 * @param request
	 */
	public static String uploadFile(HttpServletRequest request, int process, String fileType, String random){
		String operateUploadContent = operateUploadContent(request, process, fileType, random);
		return operateUploadContent;
	}
	
	/**
	 * 处理上传内容
	 * @param request
	 * @param process 进度状态值  0 询价 1预审批 2尽调 3上会 4抵押 5放贷 6贷后监测 （字典表维护）
	 * @param fileType 文件类别(字典表维护)
	 * @param random 识别码（23位识别码）
	 * 真实文件路径的格式 ../process/random/fileType/fileName
	 */
	private static String operateUploadContent(HttpServletRequest request , int process, String fileType, String random){
		
		String a = request.getSession().getServletContext().getRealPath("/");
		String b = request.getSession().getServletContext().getRealPath("");
		
		System.out.println(a);
		System.out.println(b);
		
		
		System.out.println("SEPARATOR-----------"+SEPARATOR);
		
		String separator = getSeparator();
		
		System.out.println("separator-----------"+separator);
		
		int contentLength = request.getContentLength();
		if(contentLength > maxSize){
			return "上传文件大小超出文件最大大小[" + maxSize + "]";
		}
		// 判断request
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipart){
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();//磁盘对象
			tempPath = request.getSession().getServletContext().getRealPath("/") + TEMP_PATH;
			File file = new File(tempPath);
			if(!file.exists()){
				file.mkdirs();
			}
			diskFileItemFactory.setRepository(file);//设置临时目录
			diskFileItemFactory.setSizeThreshold(1024*8);//8k的缓冲区,文件大于8K则保存到临时目录
			ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);//声明解析request的对象
			upload.setHeaderEncoding(ENCODE); //处理文件名中文
			upload.setFileSizeMax(1024 * 1024 * 10);// 设置每个文件最大为10M 
			upload.setSizeMax(maxSize);// 一共最多能上传文件大小
			String realPath = request.getSession().getServletContext().getRealPath("/") + separator + process + separator + random +separator+ fileType;
			File realPathFile = new File(realPath);
			if(!realPathFile.exists()){
				realPathFile.mkdirs();
			}
			try {
				List<FileItem> fileItems = upload.parseRequest(request);
				for(FileItem ff : fileItems){
					if(ff.isFormField()){
						System.out.println("the instance represents a simple form field");
					}else{
						String fileName = ff.getName();
						File uploadedFile = new File(realPath, fileName);
						try {
							ff.write(uploadedFile);
						} catch (Exception e) {
							e.printStackTrace();
							return "上传失败";
						} finally{
							ff.delete(); //手动删除临时文件
						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
				return "上传失败";
			}
		}else{
			//返回错误信息
			return "请求不包含multipart/form-data流";
		}
		return "上传成功";
	}
	
	
	 public static boolean convert(File sourceFile, File targetFile) {  
	        try {  
	            /** 
	             * SWFTools_HOME在系统中的安装目录  
	             * 1：window需要指定到 pdf2swf.exe 文件 
	             * 2：linux则xxx/xxx/xxx/pdf2swf即可 
	             */  
	            String SWFTools_HOME ="E:\\Program Files (x86)\\SWFTools\\pdf2swf.exe";  
	            String[] cmd = new String[5];  
	            cmd[0] = SWFTools_HOME;  
	            cmd[1] = "-i";  
	            cmd[2] = sourceFile.getAbsolutePath();  
	            cmd[3] = "-o";  
	            cmd[4] = targetFile.getAbsolutePath();  
	            Process pro =Runtime.getRuntime().exec(cmd);  
//	           如果不读取流则targetFile.exists() 文件不存在，但是程序没有问题  
//	          BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pro.getInputStream()));  
//	          while (bufferedReader.readLine() != null);  
	            pro.waitFor();  
	            pro.exitValue();  
	        } catch (Exception e) {  
	            System.out.println("pdf转换swf失败"+e);  
	            return false;  
	        }  
	        return true;  
	    }  
	 
	 /**
		 * 删除文件
		 * @param fileName 文件
		 */
		public static boolean deleteFile(String fileName, HttpServletRequest request){
			 fileName = request.getSession().getServletContext().getRealPath("") + "/" + fileName;
		     File file = new File(fileName);
		     if (file.exists() && file.isFile()) {
		            if (file.delete()) {
		            	System.out.println("删除单个文件" + fileName + "成功！");
		                return true;
		            } else {
		            	System.out.println("删除单个文件" + fileName + "失败！");
		                return false;
		            }
		        } else {
		        	System.out.println("删除单个文件失败：" + fileName + "不存在！");
		            return false;
		        }
		}
		
		private static String getSeparator(){
			return System.getProperty("file.separator");
		}
		
		private static String getRandomString(){
	    	int random=(int)(Math.random()*100000); 
	    	return String.valueOf(random);
	    }
		
		public static String getVal(){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");  
	        String dateNowStr = sdf.format(new Date());  
	        return  dateNowStr + getRandomString();
		}
		
		public static void main(String[] args) {
			String val = getVal();
			System.out.println(val);
			System.out.println(val.length());
		}
		
}
