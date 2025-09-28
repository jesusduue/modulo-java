document.addEventListener("DOMContentLoaded", () => {
      const editarModal = document.getElementById('editarModal');

      editarModal.addEventListener('show.bs.modal', function (event) {
        const button = event.relatedTarget; // Botón que abrió el modal
        if (!button) return;

        const id = button.getAttribute('data-id');
        const persona = button.getAttribute('data-persona');
        const fanpage = button.getAttribute('data-fanpage');
        const rol = button.getAttribute('data-rol');
        const estado = button.getAttribute('data-estado');

        // Pasar datos al formulario del modal
        document.getElementById('cod_rol_fan_edit').value = id || '';
        document.getElementById('fky_per_edit').value = persona || '';
        document.getElementById('fky_fan_pag_edit').value = fanpage || '';
        document.getElementById('fky_rol_edit').value = rol || '';
        document.getElementById('est_rol_fan_edit').value = estado || 'A';
      });
    });