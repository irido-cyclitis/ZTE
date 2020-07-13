1. Go to firefox
2. Open `Inspect Element` on a tab
3. On this tab, go to the `http://[IP]/manager_dev_ping_t.gch`
4. Capture the `GET` request from `Network` Tab in `Inspect Element`
5. Search for `Edit and resend` button and click on it
6. Change `GET` to `POST`
7. Go to request body and paste this
   `Host=[Host.to.ping]&PingAck=&DSCP=0&Interface=[get.it.by.right.clicking.on.the.egress.and.see.the.value.in.inspect.element] &IF_ACTION=new&IF_ERRORSTR=SUCC&IF_ERRORPARAM=SUCC&IF_ERRORTYPE=-1&IF_TIME=NULL&IF_IDLE=submit`
8. Send it !