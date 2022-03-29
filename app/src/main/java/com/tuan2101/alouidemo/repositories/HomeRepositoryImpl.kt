package com.tuan2101.alouidemo.repositories

import com.tuan2101.alouidemo.dataclasses.Service
import kotlinx.coroutines.delay

/**
 * Created by ndt2101 on 3/28/2022.
 */
class HomeRepositoryImpl(): HomeRepository {
    override suspend fun fetchTopServices(): List<Service> {
        val list = ArrayList<Service>()
        val tags = ArrayList<String>()
        tags.add("Sửa chữa điểu hòa")
        tags.add("Sửa đồ")
        tags.add("Sửa đồ")
        tags.add("Sửa đồ")

        val tags2 = ArrayList<String>()
        tags2.add("Sửa chữa điểu hòa tu lanh may giat")
        tags2.add("Sửa đồ")
        tags2.add("Sửa đồ")
        tags2.add("Sửa đồ")
        val service = Service(
            0,
            "Sửa điều hòa Kim Thành",
            true,
            "https://dstgroup.vn/wp-content/uploads/2021/05/ad8932ee4830bb6ee221.jpg",
            tags,
            0.3f,
            "08",
            "18",
            4.5f,
            null
        )

        val service2 = Service(
            0,
            "Sửa điều hòa Kim Thành",
            false,
            "https://dstgroup.vn/wp-content/uploads/2021/05/ad8932ee4830bb6ee221.jpg",
            tags2,
            0.3f,
            "08",
            "18",
            4.5f,
            "Giảm giá 30% tất cả các dịch vụ nhân dịp khai chuong cua hang"
        )
        list.add(service)
        list.add(service2)
        list.add(service)
        list.add(service)
        list.add(service)
        list.add(service)
        list.add(service)
        delay(2000)
        return list
    }

    override suspend fun fetchNewServices(): List<Service> {
        val list = ArrayList<Service>()
        val tags = ArrayList<String>()
        tags.add("Sửa chữa máy in")
        tags.add("Đổ mực")
        tags.add("Sửa đồ")
        tags.add("Sửa đồ")
        val service = Service(
            0,
            "Sửa chữa thiết bị văn phòng Kim Thành",
            false,
            "https://sivitech.vn/wp-content/uploads/2020/06/dich-vu-sua-chua-do-muc-may-in-1024x637.jpg",
            tags,
            0.3f,
            "08",
            "18",
            4.5f,
            null
        )

        val service2 = Service(
            0,
            "Sửa điều hòa Kim Thành",
            true,
            "https://dstgroup.vn/wp-content/uploads/2021/05/ad8932ee4830bb6ee221.jpg",
            tags,
            0.3f,
            "08",
            "18",
            4.5f,
            "Giảm giá 30% tất cả các dịch vụ nhân dịp khai chuong cua hang"
        )
        list.add(service)
        list.add(service2)
        list.add(service)
        list.add(service)
        list.add(service)
        list.add(service)
        list.add(service)
        delay(2000)
        return list
    }

    override suspend fun fetchSavedServices(): List<Service> {
        delay(5000)
        return ArrayList()
    }

    override suspend fun fetchAdImages(): List<String> {
        val list = ArrayList<String>()
        list.addAll(
            listOf(
                "https://scontent.fhan5-3.fna.fbcdn.net/v/t39.30808-6/271644589_279341770926758_6514186456921939312_n.jpg?_nc_cat=106&ccb=1-5&_nc_sid=e3f864&_nc_ohc=K6AVfksI1ToAX84STQC&_nc_ht=scontent.fhan5-3.fna&oh=00_AT-sS2oxAE59E4OIPAGK-MvxWcN_xmfP86wyNWlqrQUYQg&oe=62446874",
                "https://scontent.fhan5-4.fna.fbcdn.net/v/t39.30808-6/270731409_273467178180884_936605084554604672_n.jpg?_nc_cat=104&ccb=1-5&_nc_sid=730e14&_nc_ohc=Ds1KSSOu060AX_iXJsM&_nc_ht=scontent.fhan5-4.fna&oh=00_AT88ZKO6atqms10BRaICOy14O52ZjEmNDL5imusBR3cNNg&oe=6244702F",
                "https://scontent.fhan5-7.fna.fbcdn.net/v/t39.30808-6/268265386_268447682016167_2752292146128850974_n.jpg?_nc_cat=103&ccb=1-5&_nc_sid=730e14&_nc_ohc=vVu9rQ7GZakAX99nzlW&_nc_ht=scontent.fhan5-7.fna&oh=00_AT8KRfLswb2lnEJZ8fNVWv1EfyDl0MJBoZAdyG65YyZW0A&oe=62440A86"
            )
        )
        delay(1000)
        return list
    }
}