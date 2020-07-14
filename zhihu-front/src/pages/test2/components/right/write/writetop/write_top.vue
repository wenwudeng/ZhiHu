<template>
  <div id="write_top">
    <AnswerButton></AnswerButton>
    <ArticleButton></ArticleButton>
    <ThinkingButton></ThinkingButton>
  </div>
</template>
<script>
import AnswerButton from '../writetop/top_three/answer_button'
import ArticleButton from '../writetop/top_three/article_button'
import ThinkingButton from '../writetop/top_three/thinking_button'
export default {
  name: 'write_top',
  components: {
    'AnswerButton': AnswerButton,
    'ArticleButton': ArticleButton,
    'ThinkingButton': ThinkingButton
  }
}
</script>

<style scoped>

#write_top {
  height: 97px;
  width: 100%;
  background-color: white;
}
</style>
