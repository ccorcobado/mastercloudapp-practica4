# Mastercloudapp-practica4
Practica 4 - Master clouds

## Mastermind 
### UML (Versión sin paquetizar)
#### svg
<p align="center">
  <img alt="" src="https://www.plantuml.com/plantuml/img/bLJRIiGm47tFL-JH5Ve78Yj5V5eGL_OzjgCKSYb9oYBinzjEQdDjnCUUS-RCoKpIex5CsqbmGZhEZA4dPYneCSX-1LebhLQSWrw1om3N4vFiQqFEYyUiCuh3mgxmgrQZCj0gyJ58PWSbSyqRc4b0W5D2G4vYyRHmONm2z_t-FRewCiWvu2Vh09C4dnWZmV8CYS05SCvdC6PMqFkcLrVPFD8N9Y17CLeERmcHJ-Jk97wu0UryYbmm-s9ftTcFpFlGXvkZjwNzDYXfYXki5MphB8Yo4mTSCyFXlKh28U_NMuk5qfsjf-bG6ru0l83nX928yHttM9JQhYUBbXUuPtIbIQODUXNvVSPVaIqElJiqJVwaotcSkFxGVJgdpfuy8Matjs_eDDWTqsfBB7_MMkd_bIpFFQn8lb7pP2s8qPg_TDNqfO9MyJXlIRJCZaTx8KUG_Vp__W40">
</p>

#### PlantUML
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
ViewManager *-down-> View
ViewManager *-down-> TypeView

StartView ()-- StartConsoleView
ProposeCombinationView ()-- ProposeCombinationConsoleView
ResumeView ()-- ResumeConsoleView

StartConsoleView --> SecretCombinationConsoleView
ProposeCombinationConsoleView --> ErrorConsoleView
ProposeCombinationConsoleView --> GameConsoleView
GameConsoleView --> AttemptsConsoleView
GameConsoleView --> SecretCombinationConsoleView
GameConsoleView --> ColorConsoleView
GameConsoleView --> ResultConsoleView

@enduml
```

### UML (Versión con paquetes)
#### svg
<p align="center">
  <img alt="" src="https://liveuml.com/generated/c71ddcd18828fb53.png">
</p>

#### PlantUML
```PlantUML
@startuml

package mastermind {
    class Mastermind
}

package mastermind.models {
    class Session
    class State
    class Game
}

package mastermind.types {
    enum StateValue
    enum TypeView
}

package mastermind.controllers {
    abstract class Controller
    class StartController
    class ProposeCombinationController
    class ResumeController
}

package mastermind.views {
    class ViewManager
    interface View
    interface StartView
    interface ProposeCombinationView
    interface ResumeView
    
    package mastermind.views.console {
        class StartConsoleView
        class ProposeCombinationConsoleView
        class ResumeConsoleView
        class SecretCombinationConsoleView
        class ErrorConsoleView
        class ColorConsoleView
        class GameConsoleView
        class AttemptsConsoleView
        class ResultConsoleView
    }
}

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
ViewManager *-down-> View
ViewManager *-down-> TypeView

StartView ()-- StartConsoleView
ProposeCombinationView ()-- ProposeCombinationConsoleView
ResumeView ()-- ResumeConsoleView

StartConsoleView --> SecretCombinationConsoleView
ProposeCombinationConsoleView --> ErrorConsoleView
ProposeCombinationConsoleView --> GameConsoleView
GameConsoleView --> AttemptsConsoleView
GameConsoleView --> SecretCombinationConsoleView
GameConsoleView --> ColorConsoleView
GameConsoleView --> ResultConsoleView

@enduml
```
