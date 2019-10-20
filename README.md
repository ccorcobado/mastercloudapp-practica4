# mastercloudapp-practica4
Practica 4 - Master clouds

## MasterMind UML
### svg 
<p align="center">
  <img alt="" src="https://www.plantuml.com/plantuml/img/bLJBQiCm4BpxAtmk-0zAIJ6bfq1fGkwglIq6FOoq9XJoyT73jTUIh50V39gPNOrsjJeOP1edmQkguyoO-iWCWXQ3x6UWLHAruXpq35m6k1wPP3yBSd8vhCue3ewTuG-jHcMWLU9ha0m79LFD9vX90CKha9DmAH4kZ4yGrkVVCT24zUf1MhlVh0FlYoozgGXB7KM2O2TaFe4nLb4_DRswokQbVcS2KjHxIU75iESZUJZOMcf2XpnPZdGY6xfchbPf_NmBWgLBVpboccpBIW5B_pAYv524QonCBr9aplDh1qksl7IdiR4xhwKzTl-eGfxOuZlPjw8uxNooJNz8zeGkR99eoLvxMs61tcUMMsk_UAfpTIgE-CC29iEVhsPYn5yEw3JWpjjIjkN2txHM-dyXRlnfHBJscbT442EQHxgY-rn0g_ZMRqxaYiOt3t5r0DdRr_qE">
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
