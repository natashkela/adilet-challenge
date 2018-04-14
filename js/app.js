$(document).ready(function(){
  //POST data to uploadSubmit.php for processing
  $('#upload').submit(function(e){
    e.preventDefault();
    let url = "./php/uploadSubmit.php";
    //Multipart data for files
    var formData = new FormData($('#upload')[0]);
    $.ajax({
      type: "POST",
      url: url,
      data: formData,
      processData: false,
      contentType: false,
      dataType:"JSON",
      success: function(data){
        alert(data.responseText);
      },
      error: function(data){
        alert(data.responseText);
      }
    });
  });

  //POST data to checkingSubmit.php for processing
  $('#checking').submit(function(e){
    e.preventDefault();
    let url = "./php/checkSubmit.php";
    $.ajax({
      type: "POST",
      url: url,
      data: $('#checking').serialize(),
      success: function(data){
        $('#result').html(data);
      },
      error: function(data){
        $('#result').html(data);
      }
    });
  });
});
