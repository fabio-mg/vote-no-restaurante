/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.33
 * Generated at: 2016-04-17 23:58:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class DadosUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/w3.css\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("\t\r\n");
      out.write("\t<title>Batalha de Restaurantes !</title>\r\n");
      out.write("\t\r\n");
      out.write("\t<style>\r\n");
      out.write("\t\timg {\r\n");
      out.write("    \t\twidth: 100%;\r\n");
      out.write("   \t \t\theight: auto;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.button {\r\n");
      out.write("    \t\tbackground-color: #ff6600;\r\n");
      out.write("    \t\tborder: none;\r\n");
      out.write("    \t\tcolor: white;\r\n");
      out.write("    \t\tpadding: 20px 32px;\r\n");
      out.write("    \t\ttext-align: center;\r\n");
      out.write("    \t\ttext-decoration: none;\r\n");
      out.write("    \t\tdisplay: inline-block;\r\n");
      out.write("    \t\tfont-size: 20px;\r\n");
      out.write("    \t\tmargin: 4px 2px;\r\n");
      out.write("    \t\tcursor: pointer;\r\n");
      out.write("    \t\tborder-radius: 12px;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"w3-container w3-white\">\r\n");
      out.write("\t\t<img src=\"resources/logo.png\" alt=\"Logo\" style=\"width:800px;height:200px;\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"w3-row\">\r\n");
      out.write("\t\t<div class=\"w3-content\">\r\n");
      out.write("\t\t\t<form name=\"frm\" action=\"confirmaDados\" method=\"post\" onsubmit=\"return validaDados()\">\r\n");
      out.write("\t\t\t\tPrecisamos que você informe os dados abaixo para computar os seus votos ! \r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t<strong>Nome:</strong> \r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"nome\" size=\"100\"> \r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t<strong>E-Mail:</strong> \r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"email\" size=\"85\"> <br>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<input class=\"button\" type=\"submit\" name=\"action\" value=\"Confirmar\">  \r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tfunction validaDados() {\r\n");
      out.write("\t\t\tif (document.frm.nome.value.trim() == \"\" || document.frm.email.value.trim() == \"\") {\r\n");
      out.write("\t\t\t\talert(\"Campos Nome e E-mail devem ser preenchidos para computar Votos !\");\r\n");
      out.write("\t\t\t\tdocument.frm.nome.focus();\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t} else { \r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
