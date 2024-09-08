# Labyrinth Game

Detta projekt är ett enkelt textbaserat labyrintspel där spelaren kan utforska en labyrint, samla föremål och möta monster.

## Hur man kör spelet

1. Klona detta repository:

2. Öppna projektet i en IDE (t.ex. IntelliJ IDEA).
3. Kompilera och kör **Game.java**.

## Spelets instruktioner
- Använd tangenterna W, A, S, D för att flytta spelaren.
- Samla föremål och undvik monster.
- Skriv "EXIT" för att avsluta spelet.


Detta projekt är ett enkelt textbaserat labyrintspel där spelaren utforskar en labyrint, samlar föremål och möter monster. Spelet är uppdelat i flera klasser för att skapa en tydlig och enkel objektorienterad struktur. Nedan beskriver jag kort klasserna och deras viktigaste metoder samt tankarna bakom namngivningen och kopplingarna mellan klasserna.

Klasser och metoder:
Player:
move(int dx, int dy, Maze maze): Flyttar spelaren i labyrinten. dx och dy anger riktningen, och maze kontrollerar om flytten är tillåten.
attack(Monster monster): Låter spelaren attackera ett monster och minska dess hälsa.
takeDamage(int damage): Minskar spelarens hälsa när den blir skadad av ett monster.
showInventory(): Visar vilka föremål spelaren har samlat.
Metoderna i Player är namngivna så att de enkelt beskriver vad de gör, och parametrarna ger en tydlig bild av vad som hanteras i varje metod.

Monster:
move(int dx, int dy, Maze maze): Flyttar monstret i labyrinten.
decreaseHealth(int damage): Minskar monstrets hälsa när det blir attackerat.
use(Player player): Aktiveras när spelaren möter ett monster och monstret skadar spelaren.
Namnen på metoderna i Monster speglar deras roll i spelet och deras interaktion med spelaren.

Maze:
isWalkable(int x, int y): Returnerar om en specifik plats i labyrinten är möjlig att gå till.
printMaze(Player player): Skriver ut labyrinten och spelarens position.
Namnen på metoderna i Maze gör det lätt att förstå hur de hanterar labyrintens struktur och spelarens rörelser.

Game:
startGame(): Hanterar spelets huvudloop där spelaren gör val och spelet uppdateras.
Game fungerar som spelets huvudkontroll, och startGame är metoden som startar hela processen.

Item (abstrakt klass):
use(Player player): Hanterar interaktioner mellan spelaren och föremål. Implementeras i subklasser som Monster och Treasure.
Treasure och Upgrade (subklasser till Item):

use(Player player): När spelaren hittar en skatt eller uppgradering påverkas spelaren genom att få föremål eller förbättringar.
Kopplingar mellan klasser:
Player interagerar med Maze för att röra sig och med Monster och Item för att hantera strider och samla föremål. Game styr spelets logik och kontrollerar interaktionerna mellan alla klasser. Kopplingarna mellan klasserna är få och väl avgränsade, vilket gör att koden är enkel att underhålla och förstå.

Reflektion och förbättringar:
En förbättring jag gjorde var att lägga till interfacet Obstacle, som låter olika typer av hinder (som väggar och monster) hanteras på samma sätt i labyrinten. Detta gjorde koden mer flexibel. Jag tycker att antalet kopplingar mellan klasserna är lagom och gör spelet lätt att bygga ut. En potentiell förbättring skulle vara att dela upp Game-klassen för att bättre hantera specifika delar av spelets logik, som användarinmatning och uppdateringar av labyrinten.
