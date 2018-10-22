package LoginExection;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class LoginHandleException  implements HandlerExceptionResolver{

	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception exception) {
		// TODO Auto-generated method stub
		// 定义异常信息
				String msg = null;
				ModelAndView modelAndView = null;
				if (exception instanceof LoginExection) {
					// 如果是自定义异常，读取异常信息
					System.out.println(1);
					modelAndView = new ModelAndView();
					msg = exception.getMessage();
					System.out.println(msg);
					modelAndView.addObject("msg", msg);
					modelAndView.setViewName("login");
					
					
					return modelAndView;
					
				}else {
					// 如果是运行时异常，则取错误堆栈，从堆栈中获取异常信息
					Writer out = new StringWriter();
					PrintWriter s = new PrintWriter(out);
					exception.printStackTrace(s);
					msg = out.toString();

				}
				// 返回错误页面，给用户友好页面显示错误信息
			
				

			
				return modelAndView;

	}

}
