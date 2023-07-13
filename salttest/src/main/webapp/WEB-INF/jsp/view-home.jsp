<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>TEST SALT</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
	<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	<script src="https://MomentJS.com/downloads/moment.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
    <div class="container">
         <div>
            <a type="button" data-toggle="modal" data-target="#exampleModal" class="btn btn-primary btn-md" style="margin-top:50px" href="">Tambah Konsumen</a>
         </div>
         <br>
         <div class="panel panel-primary">
              <div class="panel-heading">
                <h3>List Konsumen</h3>
              </div>
              <div class="panel-body">
                  <table id="konsumen-table" class="table table-striped">
                      <thead>
                         <tr>
                            <th>No</th>
                            <th>Aksi</th>
                            <th>Nama</th>
                            <th>Alamat</th>
                            <th>Kota</th>
                            <th>Provinsi</th>
                            <th>Tanggal Registrasi</th>
                            <th>Status</th>
                         </tr>
                      </thead>
                  </table>
              </div>
       </div>
    </div>

    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Tambah Konsumen</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <form id="input-form">
              <div class="modal-body">
                  <div class="form-group">
                    <label for="addNama">Nama</label>
                    <input type="text" name="id" class="form-control" id="addId" placeholder="Id" style="display:none;"></input>
                    <input type="text" name="nama" class="form-control" id="addNama" placeholder="Nama"></input>
                  </div>
                  <div class="form-group">
                    <label for="addAlamat">Alamat</label>
                    <textarea class="form-control" id="addAlamat" name="alamat" placeholder="Alamat" rows="3"></textarea>
                  </div>
                  <div class="form-group">
                    <label for="addKota">Kota</label>
                    <input type="text" class="form-control" id="addKota" name="kota" placeholder="Kota"></input>
                  </div>
                  <div class="form-group">
                    <label for="addProvinsi">Provinsi</label>
                    <input type="text" class="form-control" id="addProvinsi" name="provinsi" placeholder="Provinsi"></input>
                  </div>
                  <div class="form-group">
                    <label for="addTgl">Tanggal Registrasi</label>
                    <input type="date" class="form-control" id="addTgl" name="tglRegistrasi" placeholder="Tanggal Registrasi"></input>
                  </div>
                  <div class="form-group">
                    <label for="addStatus">Status</label>
                    <select id="addStatus" name="status" class="form-control">
                     <option value="" selected disabled>Pilih...</option>
                     <option value="aktif">Aktif</option>
                     <option value="non-aktif">Non-Aktif</option>
                    </select>
                  </div>
              </div>
              <div class="modal-footer">
                  <button type="submit" class="btn btn-primary">Simpan</button>
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
              </div>
          </form>
        </div>
      </div>
    </div>
    <script src="/static/js/konsumen.js"></script>
</body>
</html>