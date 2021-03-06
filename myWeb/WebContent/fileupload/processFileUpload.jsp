<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.commons.fileupload.*, java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 처리</title>
</head>
<body>
<%
	if(FileUpload.isMultipartContent(request)) {
		String temporaryDir = "C:\\Temp";
		DiskFileUpload fileUpload = new DiskFileUpload();
		fileUpload.setRepositoryPath(temporaryDir);
		fileUpload.setSizeMax(1024*1024); // 최대 1메가 업로드
		fileUpload.setSizeThreshold(1024*100); // 한 번에 100키로바이트 까지는 메모리에 저장
		java.util.List fileItemList = fileUpload.parseRequest(request);
		for(int i=0; i<fileItemList.size(); i++) {
			FileItem fileItem = (FileItem) fileItemList.get(i);
			if(fileItem.isFormField()) {// 파일 이외의 파라미터
%>
			폼 파라미터: <%=fileItem.getFieldName() %> = <%=fileItem.getString() %><br>
<%
			} else { // 파일인 경우
%>
			파일: <%=fileItem.getFieldName() %> = <%=fileItem.getName() %>(<%=fileItem.getSize() %> bytes)<br>
<%
				if(fileItem.isInMemory()) {
%>
					"메모리에 저장"<br>
<%
				} else {
%>
					"디스크에 저장"<br>
<%
				}
%>
<%
				String filepath = application.getRealPath("upload");
				// 업로드한 파일이 존재하는 경우
				if(fileItem.getSize() > 0) {
					int idx = fileItem.getName().lastIndexOf("\\");
					if(idx == -1) {
						idx = fileItem.getName().lastIndexOf("/");
					}
					String fileName = fileItem.getName().substring(idx+1);
						try {
							File uploadedFile = new File(filepath, fileName);
							fileItem.write(uploadedFile);
						} catch(IOException e){}
				}
			}
		}
	} else {
%>
	인코딩 타입이 multipart/form-data가 아님.
<%
	}
%>
</body>
</html>