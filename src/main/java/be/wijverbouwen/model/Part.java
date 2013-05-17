package be.wijverbouwen.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Part {

	public Part() {}
	
	public Part(String name, double totalCost) {
		this.partName = name;
		this.totalCost = totalCost;
	}
	
    @NotNull
    @Size(max = 50)
    private String partName;

    @NotNull
    private double totalCost;

    private double amountPayed;

    private String description;

    private String imageSource;
}
