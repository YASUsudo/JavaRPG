# JavaRPG

## 概要
[スッキリわかるJava入門](http://book.impress.co.jp/books/1113101090.php)を一通り読み、実践課題としてRPGっぽいプログラムを作成。

## 仕様
- コマンドライン引数に、以下を指定可能としてください
    - 行動
    - プログラムで使う時間フォーマット
- 登場人物は以下
    - 血液型 A型の勇者（味方）
    - 血液型 A型の魔法使い（味方）
    - 血液型 AB型のボス（相手）
    - 血液型 B型の賢者（召喚される）
- 勇者、魔法使い、賢者、ボスは人間です。
- 勇者、魔法使い、賢者、ボスには名前を読み取り専用の名前をつけてください。
- 勇者、魔法使い、賢者、ボスは、職業によって量の違う数値型のHPを所持しており（HPの初期値）、HPは何らかの外部的要因によって減算され、HPが0になると自身が気絶します。
- 血液型の特徴は以下です。
    - A型：慎重なので王道な攻撃、逃げることができます。
    - AB型：二重人格なので攻撃と守ることができます。
    - B型：お気楽なので攻撃と寝ることができます。
- 職業の特徴は以下です。
    - 勇者はボスに攻撃するとボスのHPを50減らします。1/2の確立で逃げることができます。HPの初期値は100です。
    - 魔法使いは、ボスに攻撃するとボスのHPを50減らします。賢者を召喚することができます。1/3の確立で逃げることができます。HPの初期値は50です。
    - ボスは、全ての相手が倒れるまで攻撃することが可能です（1回の攻撃は50与えます）。HPは10000です。2回に1回守ります。
    - 賢者は召喚されると召喚されたtimeを使って1/5の確立で攻撃します。攻撃すると相手に10000を与えます。他は寝ます。
- Javaコマンドから味方に指示を与えることが可能です。
- RPGのルールとしては、味方（勇者・魔法使い）の行動後、相手の行動が順番に実施されます。
- 逃げる場合は、味方全員の逃げが成立しないと逃げれません。
- timeから自身の確立が成立した場合、逃げることが出来ます。
- 第一引数の行動では、最低でも以下の指示を味方にすることを可能としてください
     - 攻撃
     - 逃げる
     - 召喚
- プログラムの開始と終了に第二引数でしたフォーマットで時間を出力してください。
- もしも第ニ引数のフォーマットが正しくない場合は、独自のExceptionをスローしてください。
- どのような対戦だったか、わかるようログを出力してください。例えば、「勇者 ホゲホゲ が攻撃した。」等
- オブジェクト指向の3大機能を意識して実装してみてください。

## 自分で追加した仕様
- 全てのキャラクターは単純な「攻撃」が可能である。
- ボスは防御すると防御状態になる。防御状態の間はダメージ1/2。ターン中にボスが行動をする前には必ず防御状態が解ける。
- 生きてるキャラクターが全員逃げることが出来れば逃走成功、死んだキャラクターは考慮しない。
- 魔法使い1人につき、バトル開始前に賢者を1人召還しパーティに追加する。
- 賢者は寝てる間何もしない（回復もしない）。
- 賢者の初期HPは50。