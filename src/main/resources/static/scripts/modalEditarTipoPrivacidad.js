document.addEventListener("DOMContentLoaded", () => {
      const editarModal = document.getElementById('editarModal');

      editarModal.addEventListener('show.bs.modal', function (event) {
        const button = event.relatedTarget; // Botón que abrió el modal
        if (!button) return;

        const id = button.getAttribute('data-id');
        const nombre = button.getAttribute('data-nombre');
        const estado = button.getAttribute('data-estado');

        // Pasar datos al formulario del modal
        document.getElementById('cod_tip_edit').value = id || '';
        document.getElementById('nom_tip_edit').value = nombre || '';
        document.getElementById('est_tip_edit').value = estado || 'A';
      });
    });