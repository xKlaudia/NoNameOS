<<<<<<< HEAD
package syncMethod;

import java.util.LinkedList;
import java.util.Queue;

import processesmanagement.Process;

public class Lock 
{	
	public String name;
	private boolean state;
	private Process lockingProces;
	private Queue<Process> queueWaitingProcesses;
	
        public void addToQueue(Process process)
        {
            queueWaitingProcesses.add(process);
        }
        
	public Lock(String name) {
		this.name = name;
		this.setState(false);
		queueWaitingProcesses = new LinkedList<Process>();
	}
	
	public boolean isState()  {
		return state;
	}
	
	public void setState(boolean state)  {
		this.state = state;
	}
	
	public void displayLockingProces() {
		System.out.println(lockingProces.GetName());
	}
	
	public void lock(Process procesWhichCloses) {
		if(!isState()) {
			//zamek jest otwarty, proces zamyka zamek i rusza dalej
			setState(true);
			this.lockingProces = procesWhichCloses;
		} else {
			//zamek jest zamkniety wiec proces wedruje do kolejki i ustawiany jest jego bit blocked
			queueWaitingProcesses.offer(procesWhichCloses);
			procesWhichCloses.SetLocked();
			procesWhichCloses.SetState(3);
			
		}
	}
	
	public void unlock(Process procesWhichOpen) {
		//odblokowuje zamek i jeoli kolejka nie jest pusta to zeruje bit blocked pierwszego oczekujacego procesu.
		//if(procesWhichOpen.GetID() == this.lockingProces.GetID()) {
			this.setState(false);
			this.lockingProces = null;
			if(!queueWaitingProcesses.isEmpty()) {
				queueWaitingProcesses.peek().SetState(1);
				queueWaitingProcesses.poll().SetUnlocked();
			//}
		}
	}
}
=======
//<<<<<<< HEAD
package syncMethod;

import java.util.LinkedList;
import java.util.Queue;

import processesmanagement.Process;

public class Lock 
{	
	public String name;
	private boolean state;
	private Process lockingProces;
	private Queue<Process> queueWaitingProcesses;
	
        public void addToQueue(Process process)
        {
            queueWaitingProcesses.add(process);
        }
        
	public Lock(String name) {
		this.name = name;
		this.setState(false);
		queueWaitingProcesses = new LinkedList<Process>();
	}
	
	public boolean isState()  {
		return state;
	}
	
	public void setState(boolean state)  {
		this.state = state;
	}
	
	public void displayLockingProces() {
		System.out.println(lockingProces.GetName());
	}
	
	public void lock(Process procesWhichCloses) {
		if(!isState()) {
			//zamek jest otwarty, proces zamyka zamek i rusza dalej
			setState(true);
			this.lockingProces = procesWhichCloses;
		} else {
			//zamek jest zamkniety wiec proces wedruje do kolejki i ustawiany jest jego bit blocked
			queueWaitingProcesses.offer(procesWhichCloses);
			procesWhichCloses.SetLocked();
			procesWhichCloses.SetState(3);
			
		}
	}
	
	public void unlock(Process procesWhichOpen) {
		//odblokowuje zamek i jeoli kolejka nie jest pusta to zeruje bit blocked pierwszego oczekujacego procesu.
		//if(procesWhichOpen.GetID() == this.lockingProces.GetID()) {
			this.setState(false);
			this.lockingProces = null;
			if(!queueWaitingProcesses.isEmpty()) {
				queueWaitingProcesses.peek().SetState(1);
				queueWaitingProcesses.poll().SetUnlocked();
			//}
		}
	}
        
        public void removeProcess(Process process) {
            if (lockingProces != null) {
                if (lockingProces.equals(process)) {
                    unlock(lockingProces);
                }
                else {
                    if (queueWaitingProcesses.contains(process)) {
                        queueWaitingProcesses.remove(process);
                    }
                }
            }
        }
}
 /*       
=======
package syncMethod;

import java.util.LinkedList;
import java.util.Queue;

import processesmanagement.Process;

public class Lock 
{	
	public String name;
	private boolean state;
	private Process lockingProces;
	private Queue<Process> queueWaitingProcesses;
	
        public void addToQueue(Process process)
        {
            queueWaitingProcesses.add(process);
        }
        
	public Lock(String name) {
		this.name = name;
		this.setState(false);
		queueWaitingProcesses = new LinkedList<Process>();
	}
	
	public boolean isState()  {
		return state;
	}
	
	public void setState(boolean state)  {
		this.state = state;
	}
	
	public void displayLockingProces() {
		System.out.println(lockingProces.GetName());
	}
	
	public void lock(Process procesWhichCloses) {
		if(!isState()) {
			//zamek jest otwarty, proces zamyka zamek i rusza dalej
			setState(true);
			this.lockingProces = procesWhichCloses;
		} else {
			//zamek jest zamkniety wiec proces wedruje do kolejki i ustawiany jest jego bit blocked
			queueWaitingProcesses.offer(procesWhichCloses);
			procesWhichCloses.SetLocked();
			procesWhichCloses.SetState(3);
			
		}
	}
	
	public void unlock(Process procesWhichOpen) {
		//odblokowuje zamek i jeoli kolejka nie jest pusta to zeruje bit blocked pierwszego oczekujacego procesu.
		//if(procesWhichOpen.GetID() == this.lockingProces.GetID()) {
			this.setState(false);
			this.lockingProces = null;
			if(!queueWaitingProcesses.isEmpty()) {
				queueWaitingProcesses.peek().SetState(1);
				queueWaitingProcesses.poll().SetUnlocked();
			//}
		}
	}
>>>>>>> 5c02b49c87795086c707fecb8ee1a79e27e9f485
}*/
>>>>>>> 62f99984dead2b0c74437e747321d030da2f22a6
