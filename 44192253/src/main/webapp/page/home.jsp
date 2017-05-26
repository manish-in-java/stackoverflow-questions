<!DOCTYPE html>

<html>
  <head>
    <script type="text/javascript">
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(capturePosition);
      }
      else {
        capturePosition();
      }

      function capturePosition(position) {
        if (position && position.coords) {
          window.location = "/location?latitude=" + position.coords.latitude + "&longitude=" + position.coords.longitude;
        }
        else {
          window.location = "/location";
        }
      }
    </script>
  </head>
</html>
