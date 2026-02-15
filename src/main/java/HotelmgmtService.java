import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelmgmtservice.entity.HotelRoom;
import com.example.hotelmgmtservice.repository.HotelRepository;

@Service
public class HotelmgmtService {
	@Autowired
	private HotelRepository hotelRepo;

	public HotelRoom saveHotel(HotelRoom hotelRoom) {
		HotelRoom savedRoom = hotelRepo.save(hotelRoom);
		return savedRoom;
	}

	public HotelRoom update(HotelRoom hotel) {
		Optional<HotelRoom> hotelFound = hotelRepo.findById(hotel.getId());
		if (hotelFound.isPresent() && hotelFound.get().getAvailableQuantity() > hotel.getTotalQuantity()) {
			hotelFound.get().setAvailableQuantity(hotelFound.get().getAvailableQuantity() - hotel.getTotalQuantity());
			hotelRepo.save(hotelFound.get());
			return hotelFound.get();
		}

		return hotel;

	}

}
