<template>
  <!-- 一个遮盖层的代码！！！ -->
  <div class="black_overlay">
  </div>
</template>

<script>
export default {
    
}
</script>

<style scoped>
    .black_overlay {
        display: none; 
        position: absolute; 
        background-color: black; 
        z-index:1001; 
        -moz-opacity: 0.8; 
        opacity:0.8;
    }
</style>

