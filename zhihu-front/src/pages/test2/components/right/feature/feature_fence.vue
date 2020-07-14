<template>
  <div id="feature_part">
    <MyColloctBar></MyColloctBar>
    <MyFollowBar></MyFollowBar>
    <InvitationBar></InvitationBar>
    <DepotCenterBar></DepotCenterBar>
    <CopyriteCenterBar></CopyriteCenterBar>
  </div>
</template>
<script>
import MyColloctBar from '../feature/feature_bar/myCollect_bar'
import MyFollowBar from '../feature/feature_bar/myFollow_bar'
import InvitationBar from '../feature/feature_bar/invitation_bar'
import DepotCenterBar from '../feature/feature_bar/depotCenter_bar'
import CopyriteCenterBar from '../feature/feature_bar/copyrightCenter_bar'

export default {
  name: 'feature_part',
  components: {
    'MyColloctBar': MyColloctBar,
    'MyFollowBar': MyFollowBar,
    'InvitationBar': InvitationBar,
    'DepotCenterBar': DepotCenterBar,
    'CopyriteCenterBar': CopyriteCenterBar
  }
}
</script>

<style scoped>

#feature_part {
  margin-top: 10px;
  padding-top: 5px;
  vertical-align: top;
  display: inline-block;
  height: 205px;
  width: 100%;
  background-color: white;
  -moz-box-shadow: 0px 0px 1px gray;
  -webkit-box-shadow:0px 0px 1px gray;
  box-shadow:0px 0px 1px gray;
  border-radius:5px;
}
</style>
