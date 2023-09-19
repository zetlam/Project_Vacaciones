
 function buscarSolicitacionesTrabajador() {
    let TxtAno = document.getElementById("ano").value;	
	let TxtEstado = document.getElementById("estado").value;
	

  if (TxtAno !== "" || TxtEstado != "") {
    axios.get(
      // Substitua 'URL_DO_SEU_SERVICO_AQUI' pela URL real do seu serviço
      "EstadoPeticion",
      {
        params: { Ano: TxtAno, Estado: TxtEstado }
      }
    ).then(function (response) {
      const listaSolicitaciones = response.data;

      listaSolicitaciones.forEach((solicitacion) => {
        const id = solicitacion.idPeticion;
        const nombre = solicitacion.usuario.nombre;
        
        const fechaInicio = new Date(solicitacion.fechaInicio[0],solicitacion.fechaInicio[1]-1,solicitacion.fechaInicio[2]);
        const fechaTermino = new Date(solicitacion.fechaFin[0],solicitacion.fechaFin[1]-1,solicitacion.fechaFin[2]);
        const estado = solicitacion.estado;

        const tr = document.createElement('tr');
        tr.innerHTML = `
          <td>${id}</td>
         <td>${nombre}</td>
          <td>${fechaInicio.toLocaleDateString()}</td>
          <td>${fechaTermino.toLocaleDateString()}</td>
          <td>${estado}</td>
          <td>
            <form action="aceitarSolicitacion" method="post">
              <input type="hidden" name="idSolicitacion" value="${id}">
             
           
            <form action="negarSolicitacion" method="post">
              <input type="hidden" name="idSolicitacion" value="${id}">
              
            </form> </form>
          </td>
        `;

        const tabela = document.getElementById('solicitacoesTable');
        tabela.innerHTML=`<tr>
                    <th>ID</th>
                     <th>Usuário</th>
                    <th>Fecha de inicio</th>
                    <th>Fecha de Termino</th>
                    <th>Estado</th>
                </tr>`
        tabela.appendChild(tr);
      });
    }).catch(function (error) {
      console.error('Erro ao buscar os dados:', error);
    });
  }
}
