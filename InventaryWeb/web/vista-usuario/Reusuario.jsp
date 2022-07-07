<%-- 
    Document   : Reusuario
    Created on : 29-jun-2022, 22:22:29
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="RegistroUsuario.do" method="POST">

            <section class="vh-100" background="">
                <div class="container py-5 h-100" >

                    <div class="row d-flex justify-content-center align-items-center h-100">
                        <div class="col-12 col-md-8 col-lg-6 col-xl-5">

                            <div id="registro" class="card shadow-2-strong" style="border-radius: 1rem; background: rgba(0,0,0,0.3);">
                                <div class="card-body p-5 text-center">
                                    <h3 class="">
                                        <img class="imgusuario" src="./image/registro.png"><br>
                                        Ingrese sus datos
                                        <hr class="hrh">
                                    </h3>
                                    <div class="row register-form">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input name="txtNombreU" type="text" class="form-control" placeholder="Ingrese sus Nombre" value="" />
                                            </div>
                                            <div class="form-group">
                                                <input name="txtApellidoU" type="text" class="form-control" placeholder="Ingrese su Apellido *" value="" />
                                            </div>
                                            <div class="form-group">
                                                <input name="txtCorreoU" type="text" class="form-control" placeholder="Correo" value="" />
                                            </div>
                                            <div class="form-group">
                                                <input type="text" name="txtUsuario" class="form-control"  placeholder="Usuario" value="" />
                                            </div>
                                            <div class="form-group">
                                                <input type="password" name="txtContra" class="form-control"  placeholder="Password *" value="" />
                                            </div>
                                            <div class="form-group">
                                                <input type="text" name="txtTipoU" class="form-control"  placeholder="Tipo" value="" />
                                            </div>


                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input name="txtEstadoU" type="text" class="form-control"  placeholder="Estado" value="" />
                                            </div>
                                            
                                            <div class="form-group">
                                                <input type="text" name="txtPreguntaU" class="form-control"  placeholder="Pregunta" value="" />
                                            </div>
                                            <div class="form-group">
                                                <input name="txtRespuestaU" type="text" class="form-control"  placeholder="Respuesta" value="" />
                                            </div>




                                        </div>


                                    </div>
                                    <button style="text-align: center;" type="submit" class="btn btn-primary"> Registrar </button>
                                    <a style="text-decoration: none;" href="usuario"> Ya tengo una cuenta</a>
                                </div>
                            </div>
                        </div>
                    </div>

            </section>

        </form>
        <script>
                function EventoAlert() {
                    Swal.fire({
                        position: 'top-end',
                        icon: 'success',
                        title: 'Ha sido registrado con exito',
                        showConfirmButton: false,
                        timer: 1500
                    })
                }
            </script>
    </center>
</body>
</html>
    </body>
</html>
