<div class="container">
  <hr>
  <footer>
    <p> &copy; SMP 2015</p>
  </footer>
</div>
<span id="loader" style=" bottom:15px; right: 40px; position:absolute; display:none; ">
		<img src="${loader}" height="100" width="100">
</span>
<script>
    $(document).ajaxStart(function () {
        $('#loader').show();
    });
    $(document).ajaxStop(function () {
        $('#loader').hide();
    });
</script>

</body>
</html>