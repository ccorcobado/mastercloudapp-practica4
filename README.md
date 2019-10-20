# mastercloudapp-practica4
Practica 4 - Master clouds

## MasterMind UML
### svg 
<p align="center">
  <img alt="" src="https://www.plantuml.com/plantuml/img/bLHDQyCm3BtxL-Gyo3yOeoECdGfZBRrxYJO2_WYsGXdqnpUsiqIn7PTT0dxlINgM71qiSeEZ58orWbjR7Rb5CB9NtGmqMg7HGe2PWKiFroDN_6T1JYx7fBDQW6Dd-CFeGLjejFpg5STUgrJp2NQKG746QfGk9SA5Yn72-Vmx19gmNjshoUutRy7x8aTlAi9IHv4Ws0cPJs3jfAYUwavVLVrIlNC9AUgzfF1YsFEHF5niRJMXGvuiHoQH3IrdNWonDK_rV0lqCiA_0ZbDTfwbW6Mu6L5oOyBL4qnVMMJEy-juIxQyT6VgiJklfG_0VQCEUMABxsJVYkAqyyqsmoFP4xfG9D6IMdkbi43lC-iBOYp-vNDzAlx_3nkOR8PyDnCZ_d50Qm1t5a_PbWj_CqQR_uMutK0ZehFNl2A27D0-qXNTvm8QBRP-SoBNDB7Pqkm0gfjM_nq0">
</p>

### PlantUML
 ```PlantUML
 @startuml

class Mastermind
class Controller
class ViewManager
class StartConsoleView
class ProposeCombinationConsoleView
class ResumeConsoleView

enum StateValue
enum TypeView
enum StateView

interface View
interface StartView
interface ProposeCombinationView
interface ResumeView

Session *-down-> Game
Session *-down-> State
Session *-down-> TypeView
State *-down-> StateValue
Mastermind *-down-> Session
Mastermind *-down-> Controller
Mastermind *-down-> StateValue
Mastermind *-down-> TypeView

Controller <|-down- StartController
Controller <|-down- ProposeCombinationController
Controller <|-down- ResumeController
Controller *-down-> Session
Controller --> ViewManager
StartController --> StartView
ProposeCombinationController --> ProposeCombinationView
ResumeController --> ResumeView

View <|-down- StartView
View <|-down- ProposeCombinationView
View <|-down- ResumeView

ViewManager *-down-> StartView
ViewManager *-down-> ProposeCombinationView
ViewManager *-down-> ResumeView
ViewManager *-down-> StateView
ViewManager *-down-> View
ViewManager *-down-> TypeView

StartConsoleView <|-down- StartView
ProposeCombinationConsoleView <|-down- ProposeCombinationView
ResumeConsoleView <|-down- ResumeView

StartConsoleView --> SecretCombinationConsoleView
ProposeCombinationConsoleView --> ErrorConsoleView
ProposeCombinationConsoleView --> GameConsoleView
GameConsoleView --> AttemptsConsoleView
GameConsoleView --> SecretCombinationConsoleView
GameConsoleView --> ColorConsoleView
GameConsoleView --> ResultConsoleView

@enduml
