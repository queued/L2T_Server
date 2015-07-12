/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package l2tserver.gameserver.instancemanager;

import java.util.HashMap;
import java.util.Map;

import l2tserver.gameserver.model.actor.instance.L2RaidBossInstance;

/**
 * @author Pere
 */
public class BossManager
{
	private static Map<Integer, L2RaidBossInstance> _bosses = new HashMap<Integer, L2RaidBossInstance>();
	
	public static BossManager getInstance()
	{
		return SingletonHolder._instance;
	}
	
	public void registerBoss(L2RaidBossInstance boss)
	{
		_bosses.put(boss.getNpcId(), boss);
	}
	
	public Map<Integer, L2RaidBossInstance> getBosses()
	{
		return _bosses;
	}
	
	public L2RaidBossInstance getBoss(int id)
	{
		return _bosses.get(id);
	}
	
	public boolean isAlive(int id)
	{
		L2RaidBossInstance boss = _bosses.get(id);
		return boss != null && !boss.isDead();
	}
		
	@SuppressWarnings("synthetic-access")
	private static class SingletonHolder
	{
		protected static final BossManager _instance = new BossManager();
	}
}