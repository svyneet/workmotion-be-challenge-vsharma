package com.example.workmotion.challenge.employee;


import com.github.oxo42.stateless4j.StateMachine;
import com.github.oxo42.stateless4j.StateMachineConfig;

class StateMachineEmployee {

    StateMachineConfig<State, State> config = stateMachineConfig();
    public State changeState(State current, String next) {
        State nextState = State.valueOf(next);
        StateMachine<State, State> stateMachine = new StateMachine<>(current, config);
        stateMachine.fire(nextState);
        return stateMachine.getState();
    }

    public StateMachineConfig<State, State> stateMachineConfig() {
        StateMachineConfig<State, State> stateMachineConfig = new StateMachineConfig<>();

        stateMachineConfig.configure(State.ADDED)
                .permit(State.IN_CHECK, State.IN_CHECK);

        stateMachineConfig.configure(State.IN_CHECK)
                .permit(State.APPROVED, State.APPROVED);

        stateMachineConfig.configure(State.APPROVED)
                .permit(State.ACTIVE, State.ACTIVE);

        /*
                //boolean securityCheckDone = false;
                //boolean workPermitCheckDone = false;

                .permit(State.SECURITY_CHECK_STARTED, State.SECURITY_CHECK_STARTED)
                .permit(State.WORK_PERMIT_CHECK_STARTED, State.WORK_PERMIT_CHECK_STARTED);

                .permitIf(State.SECURITY_CHECK_FINISHED, State.APPROVED, () -> securityCheckDone && workPermitCheckDone)
                .permitIf(State.WORK_PERMIT_CHECK_FINISHED, State.APPROVED, () -> securityCheckDone && workPermitCheckDone)
                .permitIf(State.SECURITY_CHECK_FINISHED, State.SECURITY_CHECK_FINISHED, () -> !securityCheckDone || !workPermitCheckDone)
                .permitIf(State.WORK_PERMIT_CHECK_FINISHED, State.WORK_PERMIT_CHECK_FINISHED, () -> !securityCheckDone || !workPermitCheckDone);

        stateMachineConfig.configure(State.SECURITY_CHECK_FINISHED)
                .substateOf(State.IN_CHECK)
                .onExit(()-> securityCheckDone = true)
                .permitIf(State.WORK_PERMIT_CHECK_FINISHED, State.APPROVED, ()-> securityCheckDone && workPermitCheckDone);

        stateMachineConfig.configure(State.WORK_PERMIT_CHECK_FINISHED)
                .substateOf(State.IN_CHECK)
                .onExit(()-> securityCheckDone = true)
                .permitIf(State.SECURITY_CHECK_FINISHED, State.APPROVED, ()-> securityCheckDone && workPermitCheckDone);


        stateMachineConfig.configure(State.SECURITY_CHECK_STARTED)
                .substateOf(State.IN_CHECK)
                .onExit(()-> securityCheckDone = true)
                .permitIf(State.SECURITY_CHECK_FINISHED, State.SECURITY_CHECK_FINISHED, () -> !securityCheckDone || !workPermitCheckDone);

        stateMachineConfig.configure(State.WORK_PERMIT_CHECK_STARTED)
                .substateOf(State.IN_CHECK)
                .onExit(()-> securityCheckDone = true)
                .permitIf(State.WORK_PERMIT_CHECK_FINISHED, State.WORK_PERMIT_CHECK_FINISHED, () -> !securityCheckDone || !workPermitCheckDone);
*/


        return stateMachineConfig;


    }


}