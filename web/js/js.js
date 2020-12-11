$(document).ready(function(){
    $("tr td #btnDelete").click(function (){
        var idp=$(this).parent().find("#idp").val();
        eliminar(idp);
    });
    function eliminar(idp) {
        var url="ServletController?accion=Delete";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp="+idp,
            success: function (data, textStatus, jqXHR) {
               alert("Registro eliminado!");
            }
        });
    }
});

