MorseMap = {
    ".-": "A", "-...": "B", "-.-.": "C", "-..": "D", ".": "E", "..-.": "F", "--.": "G",
    "....": "H", "..": "I", ".---": "J", "-.-": "K", ".-..": "L", "--": "M", "-.": "N",
    "---": "O", ".--.": "P", "--.-": "Q", ".-.": "R", "...": "S", "-": "T",
    "..-": "U", "...-": "V", ".--": "W", "-..-": "X", "-.--": "Y", "--..": "Z",
    "span": ' ', '...---...': 'SOS'
}


msg = '.... . -.--   .--- ..- -.. .'


def decode_morse(morse_code):
    str = []
    msg = morse_code
    msg = msg.strip()
    msg = msg.replace('  ', ' span').split(' ')

    msg = list(map(lambda x: MorseMap.get(x), msg))
    msg = list(filter(lambda s: s, msg))

    for m in msg:
        str.append(m)

    return ''.join(str)


print(decode_morse('      ...---... -.-.--   - .... .   --.- ..- .. -.-. -.-   -... .-. --- .-- -.   ..-. --- -..-   .--- ..- -- .--. ...   --- ...- . .-.   - .... .   .-.. .- --.. -.--   -.. --- --. .-.-.-  '))
print(decode_morse(' . '))
print(' '.strip() and ' ')
