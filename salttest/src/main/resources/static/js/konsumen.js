let url = window.location.origin;
$(document).ready( function () {
    initTable();
});

$("#input-form").submit(function(e){
   e.preventDefault();
   const data = {
    id: $('#addId').val(),
    nama: $('#addNama').val(),
    alamat: $('#addAlamat').val(),
    kota: $('#addKota').val(),
    provinsi: $('#addProvinsi').val(),
    tglRegistrasi: $('#addTgl').val(),
    status: $('#addStatus').val(),
   }

   $.ajax({
       type: 'POST',
       url: url + "/konsumen/add",
       dataType: 'json',
       data: JSON.stringify(data),
       contentType : "application/json",
       success: function (response) {
           $('#exampleModal').modal('hide')
           $('#konsumen-table').DataTable().ajax.reload();
           resetForm();
       },
       error: function (xhr) {
        console.log(xhr)
       }
   });
});

function initTable(){
	 var table = $('#konsumen-table').DataTable({
			"sAjaxSource": url+"/konsumen/list",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
                { data: null,
                  render: function(data, type, row, meta){
                     return meta.row + meta.settings._iDisplayStart + 1;
                  }
                },
                { data: null,
                   render: function ( data, type, row ){
                        let btnAction = '<button type="button" class="btn btn-warning btn-edit-konsumen" data-id="'+data.id+'">Edit</button> <button type="button" data-id="'+data.id+'" class="btn btn-danger btn-hapus-konsumen">Hapus</button>';
                        return btnAction;
                   }
                },
                { data: "nama" },
                { data: "alamat" },
                { data: "kota" },
                { data: "provinsi" },
                { data: null,
                  render: function ( data, type, row ){
                      return moment(data.tglRegistrasi).format('DD MMM YYYY')
                  }
                },
                { data: "status" }
			]
	 })

	 table.on('click', '.btn-edit-konsumen', function(){
        resetForm();
	    let id = $(this).data('id');
	    $.ajax({
              type: 'GET',
              url: url + "/konsumen/getById/"+id,
              dataType: 'json',
              contentType : "application/json",
              success: function (response) {
                  let data = response.data;
                  $('#addId').val(data.id)
                  $('#addNama').val(data.nama)
                  $('#addAlamat').val(data.alamat)
                  $('#addKota').val(data.kota)
                  $('#addProvinsi').val(data.provinsi)
                  $('#addTgl').val(moment(data.tglRegistrasi).format('YYYY-MM-DD'))
                  $('#addStatus').val(data.status)
                  $('#exampleModal').modal('show')
              },
              error: function (xhr) {
               console.log(xhr)
              }
        });
	 })

	 table.on('click', '.btn-hapus-konsumen', function(){
	    let id = $(this).data('id');
	    $.ajax({
               type: 'DELETE',
               url: url + "/konsumen/delete/"+id,
               dataType: 'json',
               contentType : "application/json",
               success: function (response) {
                   $('#konsumen-table').DataTable().ajax.reload();
               },
               error: function (xhr) {
                console.log(xhr)
               }
        });
	 })
}

function resetForm(){
    $('#addId').val(null)
    $('#addNama').val(null)
    $('#addAlamat').val(null)
    $('#addKota').val(null)
    $('#addProvinsi').val(null)
    $('#addTgl').val(null)
    $('#addStatus').val(null)
}