
 
 function buscarSolicitaciones() {
    let TxtAno = document.getElementById("ano").value;
	let TxtUsuario = document.getElementById("usuario").value;
	let TxtEstado = document.getElementById("estado").value;
	

  if (TxtAno !== "" || TxtEstado != "" || TxtUsuario != "") {
    axios.get(
      // Substitua 'URL_DO_SEU_SERVICO_AQUI' pela URL real do seu serviço
      "BuscarSolicitudes",
      {
        params: { Ano: TxtAno, Usuario: TxtUsuario, Estado: TxtEstado }
      }
    ).then(function (response) {
      const listaSolicitaciones = response.data;
		
		const tabela = document.getElementById('solicitacoesTable');
        tabela.innerHTML=`<tr>
                    <th>ID</th>
                     <th>Usuário</th>
                    <th>Fecha de inicio</th>
                    <th>Fecha de Termino</th>
                    <th>Estado</th>
                </tr>`
                
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
            <form action="RespuestaPeticion" method="post">
              <input type="hidden" name="idPeticion" value="${id}">
              <input type="hidden" name="estado" value="ACEPTADA">
              <button type="submit" class="btn btn-success">Aceptar</button>
           </form>
           
            <form action="RespuestaPeticion" method="post">
            	<input type="hidden" name="idPeticion" value="${id}">
              <input type="hidden" name="estado" value="RECHAZADA">
              <button type="submit" class="btn btn-danger">Rechazar</button>
             </form>
          </td>
        `;

        
        tabela.appendChild(tr);
      });
    }).catch(function (error) {
      console.error('Erro ao buscar os dados:', error);
    });
  }
}


/*function imprimirSolicitudes(lista) {
  console.log(lista);
  let resultadoBusqueda = document.getElementById("listaSolicitudesDiv");
  let textoSolicitudes = "";

  for (let solicitacion of lista) {
    textoSolicitudes += `
      <div>
        <span>Título: ${solicitacion.nombre}</span>
        <span>Fecha de Inicio: ${solicitacion.fechaInicio}</span>
        <span>Fecha de Término: ${solicitacion.fechaTermino}</span>
        <span>Estado: ${solicitacion.estado}</span>
        <form action="aceptarSolicitud" method="post">
          <input type="hidden" name="idSolicitud" value="${solicitacion.id}">
          <button type="submit" class="btn btn-success">Aceptar</button>
        </form>
        <form action="negarSolicitud" method="post">
          <input type="hidden" name="idSolicitud" value="${solicitacion.id}">
          <button type="submit" class="btn btn-danger">Rechazar</button>
        </form>
      </div>
    `;
  }

  resultadoBusqueda.innerHTML = textoSolicitudes;
}
*/
