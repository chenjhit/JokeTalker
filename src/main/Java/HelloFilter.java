/**
 * Created by Administrator on 2016/11/27.
 */

import javax.servlet.*;
import java.util.*;

public class HelloFilter  implements Filter{
    public void  init(FilterConfig config) throws ServletException {
        // ��ȡ��ʼ������
        String site = config.getInitParameter("Site");

        // �����ʼ������
        System.out.println("��վ����: " + site);
    }
    public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {

        // ���վ������
        System.out.println("վ����ַ��http://www.runoob.com");

        // �����󴫻ع�����
        chain.doFilter(request,response);
    }
    public void destroy( ){
		/* �� Filter ʵ���� Web �����ӷ����Ƴ�֮ǰ���� */
    }
}
