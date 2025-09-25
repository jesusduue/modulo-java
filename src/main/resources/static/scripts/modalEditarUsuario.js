document.addEventListener("DOMContentLoaded", () => {
      const editarModal = document.getElementById('editarModal');

      editarModal.addEventListener('show.bs.modal', function (event) {
        const button = event.relatedTarget; // Botón que abrió el modal
        if (!button) return;

        const id = button.getAttribute('data-id');
        const nombre = button.getAttribute('data-nombre');
        const correo = button.getAttribute('data-correo');
        const clave = button.getAttribute('data-clave')
        const estado = button.getAttribute('data-estado');

        // Pasar datos al formulario del modal
        document.getElementById('cod_usu_edit').value = id || '';
        document.getElementById('ali_usu_edit').value = nombre || '';
        document.getElementById('ema_usu_edit').value = correo || '';
        document.getElementById('cla_usu_edit').value = clave || '';
        document.getElementById('est_usu_edit').value = estado || 'A';
      });
    });