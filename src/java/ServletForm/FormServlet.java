package ServletForm;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormularioServlet")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Obtener parámetros del formulario
        String nombre = request.getParameter("nombre");
        String edadStr = request.getParameter("edad");

        try {
            int edad = Integer.parseInt(edadStr);
            String mensaje;

            if (edad >= 18) {
                mensaje = "Hola, " + nombre + ", eres mayor de edad.";
            } else {
                mensaje = "Hola, " + nombre + ", eres menor de edad.";
            }

            // Responder con HTML
            out.println("<html><head><title>Resultado</title></head><body>");
            out.println("<h2>" + mensaje + "</h2>");
            out.println("<a href='index.html'>Volver</a>");
            out.println("</body></html>");

        } catch (NumberFormatException e) {
            out.println("<html><body><h2>Error: Ingresa una edad válida.</h2>");
            out.println("<a href='index.html'>Volver</a>");
            out.println("</body></html>");
        }
    }
}