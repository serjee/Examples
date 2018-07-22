package info.signaltrade.ws.statws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="strategy_ref" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="type_list" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="symbol_ref" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="timeframe" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="expiration" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="date_start" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="date_finish" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="all_deals" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="win_deals" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="fail_deals" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="percent_win" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="percent_fail" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="expected_payoff" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="profit_factor" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="max_drawdown" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="avg_wins" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="avg_loss" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="sl" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="tp" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="image_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="image_content" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="quality_test" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "strategyRef",
    "typeList",
    "symbolRef",
    "timeframe",
    "expiration",
    "dateStart",
    "dateFinish",
    "allDeals",
    "winDeals",
    "failDeals",
    "percentWin",
    "percentFail",
    "expectedPayoff",
    "profitFactor",
    "maxDrawdown",
    "avgWins",
    "avgLoss",
    "sl",
    "tp",
    "imageName",
    "imageContent",
    "qualityTest"
})
@XmlRootElement(name = "AddStrategyStat")
public class AddStrategyStat {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(name = "strategy_ref", required = true)
    protected String strategyRef;
    @XmlElement(name = "type_list", required = true)
    protected String typeList;
    @XmlElement(name = "symbol_ref", required = true)
    protected String symbolRef;
    @XmlElement(required = true)
    protected Integer timeframe;
    @XmlElement(required = true)
    protected Integer expiration;
    @XmlElement(name = "date_start", required = true)
    protected String dateStart;
    @XmlElement(name = "date_finish", required = true)
    protected String dateFinish;
    @XmlElement(name = "all_deals", required = true)
    protected Integer allDeals;
    @XmlElement(name = "win_deals", required = true)
    protected Integer winDeals;
    @XmlElement(name = "fail_deals", required = true)
    protected Integer failDeals;
    @XmlElement(name = "percent_win")
    protected double percentWin;
    @XmlElement(name = "percent_fail")
    protected double percentFail;
    @XmlElement(name = "expected_payoff")
    protected double expectedPayoff;
    @XmlElement(name = "profit_factor")
    protected double profitFactor;
    @XmlElement(name = "max_drawdown")
    protected double maxDrawdown;
    @XmlElement(name = "avg_wins", required = true)
    protected Integer avgWins;
    @XmlElement(name = "avg_loss", required = true)
    protected Integer avgLoss;
    @XmlElement(required = true)
    protected Integer sl;
    @XmlElement(required = true)
    protected Integer tp;
    @XmlElement(name = "image_name", required = true)
    protected String imageName;
    @XmlElement(name = "image_content", required = true)
    protected String imageContent;
    @XmlElement(name = "quality_test")
    protected double qualityTest;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the strategyRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrategyRef() {
        return strategyRef;
    }

    /**
     * Sets the value of the strategyRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrategyRef(String value) {
        this.strategyRef = value;
    }

    /**
     * Gets the value of the typeList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeList() {
        return typeList;
    }

    /**
     * Sets the value of the typeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeList(String value) {
        this.typeList = value;
    }

    /**
     * Gets the value of the symbolRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSymbolRef() {
        return symbolRef;
    }

    /**
     * Sets the value of the symbolRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSymbolRef(String value) {
        this.symbolRef = value;
    }

    /**
     * Gets the value of the timeframe property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTimeframe() {
        return timeframe;
    }

    /**
     * Sets the value of the timeframe property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTimeframe(Integer value) {
        this.timeframe = value;
    }

    /**
     * Gets the value of the expiration property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getExpiration() {
        return expiration;
    }

    /**
     * Sets the value of the expiration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setExpiration(Integer value) {
        this.expiration = value;
    }

    /**
     * Gets the value of the dateStart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateStart() {
        return dateStart;
    }

    /**
     * Sets the value of the dateStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateStart(String value) {
        this.dateStart = value;
    }

    /**
     * Gets the value of the dateFinish property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateFinish() {
        return dateFinish;
    }

    /**
     * Sets the value of the dateFinish property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateFinish(String value) {
        this.dateFinish = value;
    }

    /**
     * Gets the value of the allDeals property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAllDeals() {
        return allDeals;
    }

    /**
     * Sets the value of the allDeals property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAllDeals(Integer value) {
        this.allDeals = value;
    }

    /**
     * Gets the value of the winDeals property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWinDeals() {
        return winDeals;
    }

    /**
     * Sets the value of the winDeals property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWinDeals(Integer value) {
        this.winDeals = value;
    }

    /**
     * Gets the value of the failDeals property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFailDeals() {
        return failDeals;
    }

    /**
     * Sets the value of the failDeals property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFailDeals(Integer value) {
        this.failDeals = value;
    }

    /**
     * Gets the value of the percentWin property.
     * 
     */
    public double getPercentWin() {
        return percentWin;
    }

    /**
     * Sets the value of the percentWin property.
     * 
     */
    public void setPercentWin(double value) {
        this.percentWin = value;
    }

    /**
     * Gets the value of the percentFail property.
     * 
     */
    public double getPercentFail() {
        return percentFail;
    }

    /**
     * Sets the value of the percentFail property.
     * 
     */
    public void setPercentFail(double value) {
        this.percentFail = value;
    }

    /**
     * Gets the value of the expectedPayoff property.
     * 
     */
    public double getExpectedPayoff() {
        return expectedPayoff;
    }

    /**
     * Sets the value of the expectedPayoff property.
     * 
     */
    public void setExpectedPayoff(double value) {
        this.expectedPayoff = value;
    }

    /**
     * Gets the value of the profitFactor property.
     * 
     */
    public double getProfitFactor() {
        return profitFactor;
    }

    /**
     * Sets the value of the profitFactor property.
     * 
     */
    public void setProfitFactor(double value) {
        this.profitFactor = value;
    }

    /**
     * Gets the value of the maxDrawdown property.
     * 
     */
    public double getMaxDrawdown() {
        return maxDrawdown;
    }

    /**
     * Sets the value of the maxDrawdown property.
     * 
     */
    public void setMaxDrawdown(double value) {
        this.maxDrawdown = value;
    }

    /**
     * Gets the value of the avgWins property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAvgWins() {
        return avgWins;
    }

    /**
     * Sets the value of the avgWins property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAvgWins(Integer value) {
        this.avgWins = value;
    }

    /**
     * Gets the value of the avgLoss property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAvgLoss() {
        return avgLoss;
    }

    /**
     * Sets the value of the avgLoss property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAvgLoss(Integer value) {
        this.avgLoss = value;
    }

    /**
     * Gets the value of the sl property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSl() {
        return sl;
    }

    /**
     * Sets the value of the sl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSl(Integer value) {
        this.sl = value;
    }

    /**
     * Gets the value of the tp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTp() {
        return tp;
    }

    /**
     * Sets the value of the tp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTp(Integer value) {
        this.tp = value;
    }

    /**
     * Gets the value of the imageName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * Sets the value of the imageName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageName(String value) {
        this.imageName = value;
    }

    /**
     * Gets the value of the imageContent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageContent() {
        return imageContent;
    }

    /**
     * Sets the value of the imageContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageContent(String value) {
        this.imageContent = value;
    }

    /**
     * Gets the value of the qualityTest property.
     * 
     */
    public double getQualityTest() {
        return qualityTest;
    }

    /**
     * Sets the value of the qualityTest property.
     * 
     */
    public void setQualityTest(double value) {
        this.qualityTest = value;
    }

}
