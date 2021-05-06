package Abstract;

import Entities.Campaign;

public class BaseCampaignManager  implements CampaignService {

	@Override
	public void add(Campaign campaign) {
		System.out.println("Add to db (campaign) " + campaign.getCampaignName());		
		
	}

	@Override
	public void update(Campaign campaign) {
		System.out.println("Update to db (campaign) " + campaign.getCampaignName());	
		
	}

	@Override
	public void delete(Campaign campaign) {
		System.out.println("Delete to db (campaign) " + campaign.getCampaignName());	
		
	}

}
