package com.demo.controller;
 
import java.io.File;
import java.io.FileInputStream; 
import java.io.IOException; 

import javax.servlet.ServletContext; 
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ShowController implements ServletContextAware {
	@RequestMapping("/show")
	public String showPage(){
		System.out.println("show...");
		return "show";
	} 
	
	@RequestMapping("/file")
	public String filePage(){
		return "fileUploadAndDown";
	}
	
	@RequestMapping(consumes = "multipart/form-data", value = "/upload", method = RequestMethod.POST)  
//	@ResponseBody
	public void upload(@RequestParam("file") MultipartFile[] picfile,HttpServletRequest request, HttpServletResponse response){
		for(int i=0;i<picfile.length;i++){
			
			//获得文件名
			String fileName=picfile[i].getOriginalFilename();
//			文件名为空则说明文件不存在
			if(fileName == ""){
				System.out.println("kong");
				continue;
			}
			//后缀
//			String prefix=FilenameUtils.getExtension(fileName);
			 
			
			//1、得到上传路径
			String path=request.getSession().getServletContext().getRealPath("statics"+File.separator+"pic");
			//进行上传
			File file=new File(path,fileName);//创建文件流对象
			//判断文件是否存在，不存在则创建
			System.out.println("0000000000000000"+path);
			if(!file.exists()){
				System.out.println("1111111111111111111");
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//将文件流输出到目标文件夹中
			try {
				picfile[i].transferTo(file);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Spring这里是通过实现ServletContextAware接口来注入ServletContext对象
	private ServletContext servletContext;
	@RequestMapping("download")
	public void fileDownload(HttpServletResponse response){
		
	//获取网站部署路径(通过ServletContext对象)，用于确定下载文件位置，从而实现下载
	String path = servletContext.getRealPath("/");
	//1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
	response.setContentType("multipart/form-data");
	//2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)
	response.setHeader("Content-Disposition", "attachment;fileName="+"a.pdf");
	ServletOutputStream out;
	//通过文件路径获得File对象(假如此路径中有一个download.pdf文件)
	File file = new File(path + "download/" + "download.pdf");
	try {
	FileInputStream inputStream = new FileInputStream(file);
	//3.通过response获取ServletOutputStream对象(out)
	out = response.getOutputStream();
	int b = 0;
	byte[] buffer = new byte[512];
	while (b != -1){
	b = inputStream.read(buffer);
	//4.写到输出流(out)中
	out.write(buffer,0,b);
	}
	inputStream.close();
	out.close();
	out.flush();
	} catch (IOException e) {
	e.printStackTrace();
	}
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
