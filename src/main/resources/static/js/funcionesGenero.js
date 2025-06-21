function eliminar(id) {
  swal({
    title: "¿Está seguro de eliminar este género?",
    text: "Esta acción no se puede deshacer",
    icon: "warning",
    buttons: ["Cancelar", "Sí, eliminar"],
    dangerMode: true,
  }).then((willDelete) => {
    if (willDelete) {
      window.location.href = "/generos/eliminar/" + id;
    }
  });
}
