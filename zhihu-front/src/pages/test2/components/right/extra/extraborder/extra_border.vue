<template>
  <div id="extra_border">
    <LiveButton></LiveButton>
    <BookStoreButton></BookStoreButton>
    <DeskButton></DeskButton>
    <SpecialColButton></SpecialColButton>
    <ConsultationButton></ConsultationButton>
  </div>
</template>
<script>
import LiveButton from '../extraborder/extrabutton/Live_button'
import BookStoreButton from '../extraborder/extrabutton/BookStore_button'
import DeskButton from '../extraborder/extrabutton/Desk_button'
import SpecialColButton from '../extraborder/extrabutton/SpecialCol_button'
import ConsultationButton from '../extraborder/extrabutton/Consultation_button'
export default {
  name: 'extraborder',
  components: {
    'LiveButton': LiveButton,
    'BookStoreButton': BookStoreButton,
    'DeskButton': DeskButton,
    'SpecialColButton': SpecialColButton,
    'ConsultationButton': ConsultationButton
  }
}
</script>

<style scoped>

#extra_border {
  vertical-align: top;
  display: inline-block;
  margin-top: 10px;
  padding: 0px 10px;
  height: 130px;
  width: 276px;
  background-color: white
}
</style>
