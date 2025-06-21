function eliminar(id) {
  swal({
    title: "¿Está seguro de eliminar esta película?",
    text: "Esta acción no se puede deshacer",
    icon: "warning",
    buttons: ["Cancelar", "Sí, eliminar"],
    dangerMode: true,
  }).then((willDelete) => {
    if (willDelete) {
      window.location.href = "/peliculas/eliminar/" + id;
    }
  });
}
