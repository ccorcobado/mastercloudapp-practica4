# mastercloudapp-practica4
Practica 4 - Master clouds

## MasterMind UML
### svg 
<p align="center">
  <img alt="" src="https://www.plantuml.com/plantuml/img/ZLBD2i8m3BxdANeMzWOYoX1FWYXuhriEWxQH9CEB3--wJVTNr4i9tq_w9MGhQbbhxm0APqNCqOeY-ogK01SKgIYOLLRI8sGRSx0Ub-X5hJPmV6VWrReQOMWvehicIIwde4pE8QUjG-S-yyWmb6Rzx1pHmFf3SsAwas1E_bO5gqsq7uOpIkqnBLfC2RC89klcOBrM-31f6Wj67GMAKlYMixKj1V_vzip4_qdZ5RJATz6YErNqTvKbavva8id9zRzFuBXar-u8vll-y7qMs68ecpj-0G00">
</p>

### PlantUML
 ```PlantUML
 @startuml

class Mastermind

Session *-down-> Game
Session *-down-> State
State *-down-> StateValue
Mastermind *-down-> Session
Mastermind *-down-> Controller
Mastermind *-down-> StateValue

class Controller
Controller <|-down- StartController
Controller <|-down- ProposeCombinationController
Controller <|-down- ResumeController
Controller *-down-> Session

StartController --> StartView 
StartController --> SecretCombinationView
ProposeCombinationController --> ProposeCombinationView
ProposeCombinationController --> ErrorView
ProposeCombinationController --> GameView
GameView --> AttemptsView
GameView --> SecretCombinationView
GameView --> ColorView
GameView --> ResultView
ResumeController --> ResumeView

@enduml
