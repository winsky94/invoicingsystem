import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��ʾȫ�����������Servlet��
public class Action extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {

	// ���캯��
	public Action() {
		super();
	}

	// ����GET����
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// ���÷��͵��ͻ��˵���������
		response.setContentType("text/html;charset=GB2312");

		// ��ȡ�ͻ���д����
		PrintWriter out = response.getWriter();

		// ѭ������ÿ���ͻ������������Ϣ
		Enumeration enumParam = request.getParameterNames();
		while (enumParam.hasMoreElements()) {
			String paramName = (String) enumParam.nextElement();

			// ��ȡָ�����ƵĿͻ����������
			String[] paramValues = request.getParameterValues(paramName);

			// �����Ϊ��
			if (paramValues != null)
				// ѭ����ʾ�ÿͻ����������������ֵ
				for (int i = 0; i < paramValues.length; i++) {
					// �����ַ���ת��
					String result = new String(paramValues[i]
							.getBytes("ISO-8859-1"), "GB2312");

					// ��ͻ��������Ϣ
					out.println(paramName + " (" + i + "): " + result + "<p>");
				}
		}
	}

	// ����POST����ִ�кʹ���GET����һ���ķ���
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}