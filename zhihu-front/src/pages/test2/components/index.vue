<template>
  <div id="home_body">
      <Article></Article>
      <Aside></Aside>
  </div>
</template>

<script>
import Article from '../components/left/left_fence'
import Aside from '../components/right/right_fence'
export default {
  components: {
    'Article': Article,
    'Aside': Aside
  }
}
</script>
<style scoped>
#home_body
{
  position:absolute;
  width:99.3%;
  background-color:#f6f6f6;;
}
</style>
