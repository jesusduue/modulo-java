document.addEventListener("DOMContentLoaded", () => {
      const editarModal = document.getElementById('editarModal');

      editarModal.addEventListener('show.bs.modal', function (event) {
        const button = event.relatedTarget; // Botón que abrió el modal
        if (!button) return;

        const id = button.getAttribute('data-id');
        const nombre = button.getAttribute('data-nombre');
        const descripcion = button.getAttribute('data-descripcion');
        const estado = button.getAttribute('data-estado');

        // Pasar datos al formulario del modal
        document.getElementById('cod_rol_edit').value = id || '';
        document.getElementById('nom_rol_edit').value = nombre || '';
        document.getElementById('des_rol_edit').value = descripcion || '';
        document.getElementById('est_rol_edit').value = estado || 'A';
      });
    });