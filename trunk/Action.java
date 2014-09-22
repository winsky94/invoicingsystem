import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//显示全部请求参数的Servlet类
public class Action extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {

	// 构造函数
	public Action() {
		super();
	}

	// 处理GET请求
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 设置发送到客户端的内容类型
		response.setContentType("text/html;charset=GB2312");

		// 获取客户端写入器
		PrintWriter out = response.getWriter();

		// 循环遍历每个客户端请求参数信息
		Enumeration enumParam = request.getParameterNames();
		while (enumParam.hasMoreElements()) {
			String paramName = (String) enumParam.nextElement();

			// 获取指定名称的客户端请求参数
			String[] paramValues = request.getParameterValues(paramName);

			// 如果不为空
			if (paramValues != null)
				// 循环显示该客户端请求参数的所有值
				for (int i = 0; i < paramValues.length; i++) {
					// 进行字符集转换
					String result = new String(paramValues[i]
							.getBytes("ISO-8859-1"), "GB2312");

					// 向客户端输出信息
					out.println(paramName + " (" + i + "): " + result + "<p>");
				}
		}
	}

	// 处理POST请求，执行和处理GET请求一样的方法
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}