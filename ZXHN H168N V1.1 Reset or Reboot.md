1. Go to firefox

2. Open `Inspect Element` on a tab

3. On this tab, go to the `http://[IP]/manager_dev_conf_t.gch`

4. Capture the `GET` request from `Network` Tab in `Inspect Element`

5. Search for `Edit and resend` button and click on it

6. Change `GET` to `POST`

7. Go to request body and paste this

   * For factory reset: `IF_ACTION=devrestore&flag=2&IF_ERRORSTR=SUCC&IF_ERRORPARAM=SUCC&IF_ERRORTYPE=-1`

   * For reboot:
     `IF_ACTION=devrestart&flag=1&IF_ERRORSTR=SUCC&IF_ERRORPARAM=SUCC&IF_ERRORTYPE=-1`

8. Send it !

   OR you can run `ZTE_Reboot.java` and Enter the IP

