function eliminar(id) {
  swal({
    title: "¿Está seguro de eliminar esta película?",
    text: "Esta acción no se puede deshacer",
    icon: "warning",
    buttons: ["Cancelar", "Sí, eliminar"],
    dangerMode: true,
  }).then((willDelete) => {
    if (willDelete) {
      $.ajax({
        url: "/peliculas/" + id,
        type: "GET",
        success: function (res) {
          swal("Película eliminada con éxito", { icon: "success" }).then(() => {
            location.href = "/peliculas";
          });
        },
        error: function (xhr, status, error) {
          swal("Error al eliminar la película", { icon: "error" });
        }
      });
    }
  });
}