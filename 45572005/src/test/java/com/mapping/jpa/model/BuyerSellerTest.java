package com.mapping.jpa.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import com.mapping.jpa.dao.ExternalAccountDao;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.mapping.jpa.dao.BuyerDao;
import com.mapping.jpa.dao.SellerDao;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class BuyerSellerTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private BuyerDao buyerDao;

	@Autowired
	private SellerDao sellerDao;

	@Autowired
	private ExternalAccountDao externalAccountDao;

	@Rule
	public ExpectedException expected = ExpectedException.none();

	private ExternalAccount account;

	@Before
	public void setup() {
		account = new ExternalAccount();
		account.setId(123L);

		account = externalAccountDao.save(account);
	}

	@Test
	public void shouldNotSaveTwoBuyersWithTheSameExternalAccount() {
		Buyer buyer = buyerDao.save(getFullBuyer());

		Buyer savedBuyer = entityManager.find(Buyer.class, buyer.getId());
		ExternalAccount savedExternalAccount = savedBuyer.getExternalAccount();
		assertThat(savedExternalAccount).isNotNull();
		assertThat(savedExternalAccount.getId()).isEqualTo(account.getId());

		expected.expect(Exception.class);
		buyerDao.save(getFullBuyer());
	}

	@Test
	public void shouldNotSaveTwoSellersWithTheSameExternalAccount() {
		Seller seller = sellerDao.save(getFullSeller());

		Seller savedSeller = entityManager.find(Seller.class, seller.getId());
		ExternalAccount savedExternalAccount = savedSeller.getExternalAccount();
		assertThat(savedExternalAccount).isNotNull();
		assertThat(savedExternalAccount.getId()).isEqualTo(account.getId());

		expected.expect(Exception.class);
		sellerDao.save(getFullSeller());
	}

	@Test
	public void shouldSaveOneBuyerAndOneSellerWithTheSameExternalAccount() {
		Buyer buyer = buyerDao.save(getFullBuyer());

		Buyer savedBuyer = entityManager.find(Buyer.class, buyer.getId());
		ExternalAccount savedExternalAccount = savedBuyer.getExternalAccount();
		assertThat(savedExternalAccount).isNotNull();
		assertThat(savedExternalAccount.getId()).isEqualTo(account.getId());

		Seller seller = sellerDao.save(getFullSeller());

		Seller savedSeller = entityManager.find(Seller.class, seller.getId());
		savedExternalAccount = savedSeller.getExternalAccount();
		assertThat(savedExternalAccount).isNotNull();
		assertThat(savedExternalAccount.getId()).isEqualTo(account.getId());
	}

	@Test
	public void shouldNotSaveTwoBuyersAndOneSellerWithTheSameExternalAccount() {
		Buyer buyer = buyerDao.save(getFullBuyer());

		Buyer savedBuyer = entityManager.find(Buyer.class, buyer.getId());
		ExternalAccount savedExternalAccount = savedBuyer.getExternalAccount();
		assertThat(savedExternalAccount).isNotNull();
		assertThat(savedExternalAccount.getId()).isEqualTo(account.getId());

		sellerDao.save(getFullSeller());

		expected.expect(Exception.class);
		buyerDao.save(getFullBuyer());
	}

	@Test
	public void shouldNotSaveOneBuyerAndTwoSellersWithTheSameExternalAccount() {
		Buyer buyer = buyerDao.save(getFullBuyer());

		Buyer savedBuyer = entityManager.find(Buyer.class, buyer.getId());
		ExternalAccount savedExternalAccount = savedBuyer.getExternalAccount();
		assertThat(savedExternalAccount).isNotNull();
		assertThat(savedExternalAccount.getId()).isEqualTo(account.getId());

		sellerDao.save(getFullSeller());

		expected.expect(Exception.class);
		sellerDao.save(getFullSeller());
	}

	private Buyer getFullBuyer() {
		Buyer buyer = new Buyer();
		buyer.setBirthdate(LocalDateTime.now());
		buyer.setEmail("buyer@email.com");
		buyer.setName("Buyer Name");
		buyer.setExternalAccount(account);

		return buyer;
	}

	private Seller getFullSeller() {
		Seller seller = new Seller();
		seller.setBirthdate(LocalDateTime.now());
		seller.setEmail("seller@email.com");
		seller.setName("Seller Name");
		seller.setExternalAccount(account);

		return seller;
	}

}
