function eliminar(id) {
  swal({
    title: "¿Está seguro de eliminar este género?",
    text: "Esta acción no se puede deshacer",
    icon: "warning",
    buttons: ["Cancelar", "Sí, eliminar"],
    dangerMode: true,
  }).then((willDelete) => {
    if (willDelete) {
      $.ajax({
        url: "/generos/" + id,
        type: "GET",
        success: function (res) {
          swal("Género eliminado con éxito", { icon: "success" }).then(() => {
            location.href = "/generos";
          });
        },
        error: function (xhr, status, error) {
          swal("Error al eliminar el género", { icon: "error" });
        }
      });
    }
  });
}