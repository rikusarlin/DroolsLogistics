package fi.kela.drools.util;

import org.jbpm.workflow.instance.node.RuleSetNodeInstance;
import org.kie.api.KieServices;
import org.kie.api.event.process.ProcessCompletedEvent;
import org.kie.api.event.process.ProcessEventListener;
import org.kie.api.event.process.ProcessNodeLeftEvent;
import org.kie.api.event.process.ProcessNodeTriggeredEvent;
import org.kie.api.event.process.ProcessStartedEvent;
import org.kie.api.event.process.ProcessVariableChangedEvent;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KnowledgeSessionHelper {

    static Logger logger = LoggerFactory.getLogger(KnowledgeSessionHelper.class.getName());

	public static KieContainer createRuleBase() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kieContainer = ks.getKieClasspathContainer();
		return kieContainer;
	}
	
	public static StatelessKieSession getStatelessKnowledgeSession(KieContainer kieContainer, String sessionName) {
		StatelessKieSession kSession = kieContainer.newStatelessKieSession(sessionName);
		return kSession;
	}

	public static KieSession getStatefulKnowledgeSession(KieContainer kieContainer, String sessionName) {
		KieSession kSession = kieContainer.newKieSession(sessionName);
		return kSession;
	}

	  public static KieSession getStatefulKnowledgeSessionWithCallback(KieContainer kieContainer, String sessionName) {
	        KieSession session = getStatefulKnowledgeSession(kieContainer, sessionName);
	        session.addEventListener(new RuleRuntimeEventListener() {
	            public void objectInserted(ObjectInsertedEvent event) {
	               logger.debug("Object inserted \n"
	                        + event.getObject().toString());
	            }
	            public void objectUpdated(ObjectUpdatedEvent event) {
	            	logger.debug("Object was updated \n"
	                        + "new Content \n" + event.getObject().toString());
	            }
	            public void objectDeleted(ObjectDeletedEvent event) {
	            	logger.debug("Object retracted \n"
	                        + event.getOldObject().toString());
	            }
	        });
	        session.addEventListener(new AgendaEventListener() {
	            public void matchCreated(MatchCreatedEvent event) {
	            	logger.debug("The rule "
	                        + event.getMatch().getRule().getName()
	                        + " can be fired in agenda");
	            }
	            public void matchCancelled(MatchCancelledEvent event) {
	            	logger.debug("The rule "
	                        + event.getMatch().getRule().getName()
	                        + " cannot b in agenda");
	            }
	            public void beforeMatchFired(BeforeMatchFiredEvent event) {
	            	logger.debug("The rule "
	                        + event.getMatch().getRule().getName()
	                        + " will be fired");
	            }
	            public void afterMatchFired(AfterMatchFiredEvent event) {
	            	logger.debug("The rule "
	                        + event.getMatch().getRule().getName()
	                        + " has been fired");
	            }
	            public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
	            }
	            public void agendaGroupPushed(AgendaGroupPushedEvent event) {
	            }
	            public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
	            }
	            public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
	            }
	            public void beforeRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
	            }
	            public void afterRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
	            }
	        });
	        return session;
	  }
	 
	  public static KieSession getStatefulKnowledgeSessionForJBPM(
	            KieContainer kieContainer, String sessionName) {
	          KieSession session = getStatefulKnowledgeSessionWithCallback(kieContainer,sessionName);
	        session.addEventListener(new ProcessEventListener() {

	              public void beforeVariableChanged(ProcessVariableChangedEvent arg0) {
	                  // TODO Auto-generated method stub

	              }

	              public void beforeProcessStarted(ProcessStartedEvent arg0) {
	                  System.out.println("Process Name "+arg0.getProcessInstance().getProcessName()+" has been started");
	              }

	              public void beforeProcessCompleted(ProcessCompletedEvent arg0) {
	                  // TODO Auto-generated method stub

	              }

	              public void beforeNodeTriggered(ProcessNodeTriggeredEvent arg0) {
	                  // TODO Auto-generated method stub

	              }

	              public void beforeNodeLeft(ProcessNodeLeftEvent arg0) {
	                 if (arg0.getNodeInstance() instanceof RuleSetNodeInstance){
	                	 logger.debug("Node Name "+ arg0.getNodeInstance().getNodeName()+" has been left");        
	                  }

	              }

	              public void afterVariableChanged(ProcessVariableChangedEvent arg0) {
	                  // TODO Auto-generated method stub

	              }

	              public void afterProcessStarted(ProcessStartedEvent arg0) {

	              }

	              public void afterProcessCompleted(ProcessCompletedEvent arg0) {
	            	  logger.debug("Process Name "+arg0.getProcessInstance().getProcessName()+" has stopped");


	              }

	              public void afterNodeTriggered(ProcessNodeTriggeredEvent arg0) {
	                  if (arg0.getNodeInstance() instanceof RuleSetNodeInstance){
	                	  logger.debug("Node Name "+ arg0.getNodeInstance().getNodeName()+" has been entered");        
	                  }
	              }

	              public void afterNodeLeft(ProcessNodeLeftEvent arg0) {
	               }
	          });
	        return session;
	    }
}
