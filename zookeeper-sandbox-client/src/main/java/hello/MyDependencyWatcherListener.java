package hello;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.zookeeper.discovery.watcher.DependencyState;
import org.springframework.cloud.zookeeper.discovery.watcher.DependencyWatcherListener;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(value = "hello.MyDependencyWatcherListener.enabled", havingValue="true")
public class MyDependencyWatcherListener implements DependencyWatcherListener {
	
	@Override
	public void stateChanged(String dependencyName, DependencyState newState) {
		System.out.println("[stateChanged] For '"+dependencyName+"' to state: "+newState);
		
	}
}
